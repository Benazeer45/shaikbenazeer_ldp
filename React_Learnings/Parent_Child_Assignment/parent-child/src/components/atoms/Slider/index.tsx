import { Slider } from '@mui/material';
import { styled } from '@mui/material/styles';

export interface StyledMoleculeProps {
  value: number; // Value passed from parent
  onChange: (event: Event, value: number | number[]) => void; // Change handler passed from parent
  color?: string;
  width?: string;
}

const CustomSlider = styled(Slider, {
  shouldForwardProp: (prop) => prop !== 'color',
})<{ color: string }>(({ theme, color }) => ({
  height: 8,
  '& .MuiSlider-thumb': {
    width: 23,
    height: 23,
    borderRadius: '8px',
    border: '3px solid #B4A9FF',
    backgroundColor: color,
    '&:hover, &:focus': {
      boxShadow: 'none',
    },
  },
  '& .MuiSlider-track': {
    border: 'none',
    backgroundColor: '#6C5DD3',
  },
  '& .MuiSlider-rail': {
    opacity: 0.3,
    backgroundColor: theme.palette.grey[400],
  },
}));

export const CustomizedSlider = ({ value, onChange, color = '#6C5DD3', width = '100%' }: StyledMoleculeProps) => (
  <div style={{ width }}>
    <CustomSlider
      value={value} // Use the value prop here
      onChange={onChange} // Handle the change event
      min={0}
      max={880000}
      step={1}
      aria-labelledby="continuous-slider"
      color="primary" // Use color from props
    />
  </div>
);
