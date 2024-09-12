import React, { useState } from 'react';
import { Typography, Box, styled } from '@mui/material';
import { TextWithIcon } from '../../molecules/TextWithIcon'; // Import from molecules
import { Line } from '../../atoms/Divider'; // Import Line from atoms
import { Button } from '../../atoms/Button'; // Import from atoms
import { CustomizedSlider } from '../../atoms/Slider'; // Import the customized slider component

export const SummarySection: React.FC = () => {
  const [values, setValues] = useState({
    paybackAmount: 0,
    rate: 12.00,
    rateAmount: 0,
    totalPayable: 0,
  });

  const [sliderValue, setSliderValue] = useState<number>(0); // State for slider value
  const [resetDisabled, setResetDisabled] = useState(true); // State to disable the Reset button

  // Callback function to handle slider value change
  const handleSliderChange = (event: Event, value: number | number[]) => {
    const newValue = typeof value === 'number' ? value : value[0];
    const newPaybackAmount = newValue;
    const interestAmount = newPaybackAmount * (values.rate / 100);
    const totalPayable = Math.min(newPaybackAmount + interestAmount, 880000);

    setSliderValue(newPaybackAmount); // Update slider value
    setValues({
      paybackAmount: newPaybackAmount,
      rate: values.rate,
      rateAmount: interestAmount,
      totalPayable: totalPayable,
    });
    setResetDisabled(newPaybackAmount === 0); // Disable reset if paybackAmount is 0
  };

  // Handler for the reset button
  const handleReset = () => {
    setValues({
      paybackAmount: 0,
      rate: 12.00,
      rateAmount: 0,
      totalPayable: 0,
    });
    setSliderValue(0); // Reset slider value
    setResetDisabled(true); // Disable the Reset button after resetting
  };

  const StyledButton = styled(Button, {
    shouldForwardProp: (prop) => prop !== 'disabled',
  })<{ disabled?: boolean }>(({ disabled }) => ({
    width: '65px',
    height: '31px',
    padding: '6px 12px',
    borderRadius: '8px',
    backgroundColor: disabled ? '#a1a1aa1a' : '#2D2D30',
    fontSize: '12px',
    color: disabled ? '#000000' : '#C9C8CC',
  }));

  return (
    <Box>
      <Box display="flex" alignItems="center" gap="8px" mb={2}>
        <TextWithIcon text="Summary" iconSrc="/assets/icons/icon.svg" />
      </Box>
      
      <Box mb={2} display="flex" justifyContent="space-between">
        <Typography variant="body2" color="#A5A5A6" fontWeight={500}>Term</Typography>
        <Typography variant="body2" color="#E8E7F0" fontWeight={500} textAlign="right">12 months</Typography>
      </Box>
      
      <Box mb={2} display="flex" justifyContent="space-between">
        <Typography variant="body2" color="#A5A5A6" fontWeight={500}>Selected contracts</Typography>
        <Typography variant="body2" color="#E8E7F0" fontWeight={500} textAlign="right">0</Typography>
      </Box>

      <Box mb={2} display="flex" justifyContent="space-between" alignItems="center">
        <Typography variant="body2" color="#a6a6a5" fontWeight={500}>Slide to autoselect</Typography>
        <StyledButton
          onClick={handleReset}
          disabled={resetDisabled} // Disable the Reset button based on resetDisabled state
        >
          Reset
        </StyledButton>
      </Box>
      <CustomizedSlider
        value={sliderValue} // Pass slider value to the component
        onChange={handleSliderChange} // Handle slider change
      />
      
      <Box mb={2} display="flex" alignItems="center">
        <Typography variant="body2" color="#A5A5A6">
          <span style={{ color: '#B4A9FF', marginRight: '4px' }}>${values.paybackAmount.toFixed(2)}</span>
          selected of
        </Typography>
        <Typography variant="body2" color="#E8E7F0" fontWeight={500} ml={1}>$880,000.00</Typography>
      </Box>

      <Box mb={2} display="flex" justifyContent="space-between">
        <Typography variant="body2" color="#A5A5A6" fontWeight={500}>Pay back amount</Typography>
        <Typography variant="body2" color="#E8E7F0" fontWeight={500} textAlign="right">${values.paybackAmount.toFixed(2)}</Typography>
      </Box>

      <Box mb={2} display="flex" justifyContent="space-between" alignItems="center">
        <Typography variant="body2" color="#A5A5A6" fontWeight={500}>Rate %</Typography>
        <Box display="flex" alignItems="center">
          <Typography variant="body2" color="#A5A5A6">({values.rate.toFixed(2)}%)</Typography>
          <Typography variant="body2" color="#E8E7F0" fontWeight={500} ml={1}>${values.rateAmount.toFixed(2)}</Typography>
        </Box>
      </Box>

      <Box mb={2}>
        <Line />
      </Box>

      <Box mb={2} display="flex" justifyContent="space-between">
        <Typography variant="body2" color="#A5A5A6" fontWeight={500}>Total Payable</Typography>
        <Typography variant="body2" color="#E8E7F0" fontWeight={600} textAlign="right">${values.totalPayable.toFixed(2)}</Typography>
      </Box>

      <Button
        onClick={handleReset}
        disabled={resetDisabled}
      >
        Review your credit
      </Button>
    </Box>
  );
};
