import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import Heading from '../Typography'; // Ensure the correct import path

// Define the Storybook metadata
const meta: Meta<typeof Heading> = {
    title: 'Atoms/Heading',
    component: Heading,
    argTypes: {
        children: { control: 'text' },
        size: { control: 'text' },
        weight: { control: 'number' },
        color: { control: 'color' },
        lineHeight: { control: 'text' },
        style: { control: 'object' },
    },
};

export default meta;

// Define the default story
const Template: StoryFn<typeof Heading> = (args) => <Heading {...args} />;


export const CustomTypography = Template.bind({});
CustomTypography.args = {
    children: 'Cash Acceleration',
    size: '36px',
    weight: 900,
    color: '#E8E7F0',
    lineHeight: '48px',
    style: { textAlign: 'left' }, // Additional custom styles
};
