// src/components/atoms/Line.stories.tsx
import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { Line } from '../Divider';

// Meta configuration for the Line component
export default {
  title: 'Atoms/Divider', // Storybook category and component name
  component: Line,
  argTypes: {
    opacity: {
      control: { type: 'range', min: 0, max: 1, step: 0.1 }, // Control for opacity (range slider)
      description: 'Opacity of the line',
      defaultValue: 0.5,
    },
    borderColor: {
      control: 'color', // Control for border color
      description: 'Border color of the line',
      defaultValue: '#757575', // Default grey color
    },
    width: {
      control: 'text', // Control for width
      description: 'Width of the line',
      defaultValue: '276px',
    },
  },
} as Meta<typeof Line>;

// Template for creating stories
const Template: StoryFn<typeof Line> = (args) => <Line {...args} />;

// Default Line story
export const Default = Template.bind({});
Default.args = {
  opacity: 0.5,
  borderColor: '#757575', // Default grey color
  width: '276px', // Default width
};

// Customizable Line story
export const Customizable = Template.bind({});
Customizable.args = {
  opacity: 0.8,
  borderColor: '#4a90e2', // Custom border color
  width: '300px', // Custom width
};
