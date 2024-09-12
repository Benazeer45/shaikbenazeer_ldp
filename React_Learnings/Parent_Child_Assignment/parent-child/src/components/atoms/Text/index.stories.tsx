// src/components/atoms/Text.stories.tsx
import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { Text } from '../Text'; // Import your Text component

// Meta configuration for the Text component
export default {
  title: 'Atoms/Text', // Storybook category and component name
  component: Text,
  argTypes: {
    children: {
      control: 'text',
      description: 'Text content to display',
      defaultValue: 'Sample Text',
    },
    fontSize: {
      control: 'text',
      description: 'Font size of the text',
      defaultValue: '16px',
    },
    fontWeight: {
      control: 'number',
      description: 'Font weight of the text',
      defaultValue: 400,
    },
    color: {
      control: 'color',
      description: 'Color of the text',
      defaultValue: '#000000',
    },
    textAlign: {
      control: {
        type: 'select',
        options: ['left', 'center', 'right', 'justify'],
      },
      description: 'Text alignment',
      defaultValue: 'left',
    },
    lineHeight: {
      control: 'text',
      description: 'Line height of the text',
      defaultValue: 'normal',
    },
  },
} as Meta<typeof Text>;

// Template for creating stories
const Template: StoryFn<typeof Text> = (args) => <Text {...args} />;

// Default Text story with controls
export const Default = Template.bind({});
Default.args = {
  children: 'Sample Text',
  fontSize: '16px',
  fontWeight: 400,
  color: '#000000',
  textAlign: 'left',
  lineHeight: 'normal',
};

// Custom Text story to test different styles
export const Custom = Template.bind({});
Custom.args = {
  children: 'Customized Text',
  fontSize: '20px',
  fontWeight: 700,
  color: '#007bff',
  textAlign: 'center',
  lineHeight: '1.5',
};
