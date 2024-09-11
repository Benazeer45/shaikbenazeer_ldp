import React from 'react';
import { Meta, StoryFn } from '@storybook/react'; // Use StoryFn instead of Story
import Icons from '../Icon'; // Ensure the correct import path


// Define the Storybook metadata
const meta: Meta<typeof Icons> = {
    title: 'Atoms/Icons',
    component: Icons,
    argTypes: {
        src: { control: 'text' },
        width: { control: 'text' },
        height: { control: 'text' },
        alt: { control: 'text' },
    },
};

export default meta;

// Define the default story
const Template: StoryFn<typeof Icons> = (args) => <Icons {...args} />;

// Export different variations of the component
export const CustomIcon = Template.bind({});
CustomIcon.args = {
    src: '/assets/icons/icon1.svg', // Path to the icon in the public directory
    width: '30px',
    height: '28px',
    alt: 'Default Icon',
};


