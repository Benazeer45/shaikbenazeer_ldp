import React from 'react';
import { Meta, StoryFn } from '@storybook/react'; // Use StoryFn instead of Story
import Button from '../Button'; // Adjust the import path if needed

// Define the meta information for the Button component
const meta: Meta<typeof Button> = {
  title: 'Atoms/Button', // Defines the category and name in Storybook
  component: Button,
  argTypes: {
    text: { control: 'text' },
    onClick: { action: 'clicked' },
    style: { control: 'object' },
  },
};

export default meta;

// Define a template for the Button component stories
const Template: StoryFn<typeof Button> = (args) => <Button {...args} />;

// Define a custom style story for the Button component
export const CustomStyle: StoryFn<typeof Button> = Template.bind({});
CustomStyle.args = {
  text: 'New Cash Kick', // Text to display on the button
  style: { 
    backgroundColor: '#4CAF50', // Green background color
    color: '#fff' // White text color
  },
};
