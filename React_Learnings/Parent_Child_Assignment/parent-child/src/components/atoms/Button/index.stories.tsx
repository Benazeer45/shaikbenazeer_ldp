// src/components/atoms/Button.stories.tsx
import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { Button } from '../Button'; // Import your Button component

// Meta configuration for the Button component
export default {
  title: 'Atoms/Button', // Storybook category and component name
  component: Button,
  argTypes: {
    children: {
      control: 'text', // Control for the button label
      description: 'Text inside the button',
      defaultValue: 'Click Me',
    },
    disabled: {
      control: 'boolean', // Toggle disabled state
      description: 'Disable the button',
      defaultValue: false,
    },
    onClick: { action: 'clicked' }, // Logs click events in Storybook actions panel
  },
} as Meta<typeof Button>;

// Template for creating stories
const Template: StoryFn<typeof Button> = (args) => <Button {...args} />;

// Default Button story with controls
export const Default = Template.bind({});
Default.args = {
  children: 'Click Me', // Default button label
};

// Disabled Button story with controls
export const Disabled = Template.bind({});
Disabled.args = {
  children: 'Disabled Button',
  disabled: true, // Disabled state
};

// Custom Button story to test different sizes or other properties
export const Custom = Template.bind({});
Custom.args = {
  children: 'Custom Styled Button',
  disabled: false,
  style: { backgroundColor: '#6a1b9a', color: '#fff' }, // Custom style control
};
