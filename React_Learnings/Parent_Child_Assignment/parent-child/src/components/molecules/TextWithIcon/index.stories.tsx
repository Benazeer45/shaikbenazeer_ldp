// src/components/atoms/TextWithIcon.stories.tsx
import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { TextWithIcon } from '../TextWithIcon';

// Import a sample SVG icon from the public assets
const iconSrc = 'assets/icons/icon.svg'; // Adjust the path if needed

export default {
  title: 'Molecules/TextWithIcon', // Storybook category and component name
  component: TextWithIcon,
  argTypes: {
    text: {
      control: 'text',
      description: 'Text to display next to the icon',
      defaultValue: 'Sample Text',
    },
    iconSrc: {
      control: 'text',
      description: 'Path to the icon source',
      defaultValue: iconSrc,
    },
    color: {
      control: 'color', // Add color control
      description: 'Color of the text',
      defaultValue: '#E8E7F0', // Default color
    },
  },
} as Meta<typeof TextWithIcon>;

// Template for creating stories
const Template: StoryFn<typeof TextWithIcon> = (args) => <TextWithIcon {...args} />;

// Default TextWithIcon story with controls
export const Default = Template.bind({});
Default.args = {
  text: 'Sample Text',
  iconSrc: iconSrc, // Use the sample icon path
  color: '#E8E7F0', // Default color
};

// Custom TextWithIcon story with different text, icon, and color
export const Custom = Template.bind({});
Custom.args = {
  text: 'Custom Text',
  iconSrc: iconSrc, // Use the sample icon path or provide a different one
  color: '#FF5722', // Example custom color
};
