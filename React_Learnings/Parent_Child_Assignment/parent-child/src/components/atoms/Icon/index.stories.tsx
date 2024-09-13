// src/components/atoms/Icon.stories.tsx
import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { Icon } from '../Icon'; // Import your Icon component

// Meta configuration for the Icon component
export default {
  title: 'Atoms/Icon', // Storybook category and component name
  component: Icon,
  argTypes: {
    src: {
      control: 'text', // Control for the icon source URL
      description: 'Path to the SVG file or image source',
      defaultValue: '/assets/icons/icon.svg', // Default path to the local SVG
    },
    width: {
      control: 'text', // Control for icon width
      description: 'Width of the icon',
      defaultValue: '40px',
    },
    height: {
      control: 'text', // Control for icon height
      description: 'Height of the icon',
      defaultValue: '40px',
    },
    alt: {
      control: 'text', // Control for alternative text
      description: 'Alternative text for the icon',
      defaultValue: 'Icon',
    },
  },
} as Meta<typeof Icon>;

// Template for creating stories
const Template: StoryFn<typeof Icon> = (args) => <Icon {...args} />;

// Default Icon story with controls
export const Default = Template.bind({});
Default.args = {
  src: '/assets/icons/icon.svg', // Default path to the local SVG
  width: '40px', // Default width
  height: '40px', // Default height
};

// Custom Icon story to test different sizes or other properties
export const Custom = Template.bind({});
Custom.args = {
  src: '/assets/icons/icon.svg', // Path to the local SVG (can be changed as needed)
  width: '60px', // Custom width
  height: '60px', // Custom height
};
