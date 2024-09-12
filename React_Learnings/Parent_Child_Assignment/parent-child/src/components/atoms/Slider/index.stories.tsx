// src/components/atoms/Slider/index.stories.tsx
import React from 'react';
import { StoryFn, Meta } from '@storybook/react'; // Use StoryFn instead of Story
import { CustomizedSlider, StyledMoleculeProps } from '../Slider';

export default {
  title: 'Atoms/StyledMolecule',
  component: CustomizedSlider,
} as Meta;

const Template: StoryFn<StyledMoleculeProps> = (args) => <CustomizedSlider {...args} />;

export const Default = Template.bind({});
Default.args = {
  onChange: (event: Event, value: number | number[]) => {
    console.log('Slider value changed:', value);
  },
  color: '#6C5DD3', // Default slider color
  width: '100%', // Default slider width
};

export const Custom = Template.bind({});
Custom.args = {
  onChange: (event: Event, value: number | number[]) => {
    console.log('Slider value changed:', value);
  },
  color: '#FF5733', // Custom slider color
  width: '80%', // Custom slider width
};
