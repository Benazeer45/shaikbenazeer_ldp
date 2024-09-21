// src/components/atoms/Slider/index.stories.tsx
import React from 'react';
import { StoryFn, Meta } from '@storybook/react'; // Use StoryFn instead of Story
import { CustomizedSlider, SliderProps } from '../Slider';

export default {
  title: 'Atoms/Slider',
  component: CustomizedSlider,
} as Meta;

const Template: StoryFn<SliderProps> = (args) => <CustomizedSlider {...args} />;

export const Default = Template.bind({});
Default.args = {
  onChange: (event: Event, value: number | number[]) => {
    console.log('Slider value changed:', value);
  },
};

export const Custom = Template.bind({});
Custom.args = {
  onChange: (event: Event, value: number | number[]) => {
    console.log('Slider value changed:', value);
  },
};
