// src/components/atoms/Slider.tsx
import React from 'react';
import { Slider } from '@mui/material';
import { styled } from '@mui/material/styles';

export interface SliderProps {
  value: number; // Value passed from parent
  onChange: (event: Event, value: number | number[]) => void; // Change handler passed from parent
  max: number; // Maximum value for the slider
}

const CustomSlider = styled(Slider)(({ theme }) => ({
  height: 8,
  '& .MuiSlider-thumb': {
    width: 23,
    height: 23,
    borderRadius: '8px',
    border: '3px solid #B4A9FF',
    backgroundColor: '#6C5DD3', // Hardcoded color
    '&:hover, &:focus': {
      boxShadow: 'none',
    },
  },
  '& .MuiSlider-track': {
    border: 'none',
    backgroundColor: '#6C5DD3', // Hardcoded color
  },
  '& .MuiSlider-rail': {
    opacity: 0.3,
    backgroundColor: theme.palette.grey[400],
  },
}));

export const CustomizedSlider: React.FC<SliderProps> = ({ value, onChange, max }) => (
  <div style={{ width: '100%' }}> {/* Hardcoded width */}
    <CustomSlider
      value={value} // Use the value prop here
      onChange={onChange} // Handle the change event
      min={0}
      max={max} // Pass max value from props
      step={1}
      aria-labelledby="continuous-slider"
    />
  </div>
);
