import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import Button from '../Button'; // Adjust the path as needed

export default {
  title: 'Atoms/Button', // Defines the category and name in Storybook
  component: Button,
  argTypes: {
    text: { control: 'text' }, // Control for button text
    onClick: { action: 'clicked' }, // Action for click events
    style: { control: 'object' }, // Control for custom styles
  },
} as Meta<typeof Button>;

// Template for creating stories
const Template: StoryFn<typeof Button> = (args) => <Button {...args} />;

// Story for the Button
export const CustomButton = Template.bind({});
CustomButton.args = {
  text: 'New Cash Kick', // Custom text on the button
  style: {
    backgroundColor: '#6C5DD3', // Purple background color
    color: '#fff', // White text color
    padding: '10px 20px', // Custom padding
    fontFamily: 'Gilroy-Bold', // Apply Gilroy font
  },
};
