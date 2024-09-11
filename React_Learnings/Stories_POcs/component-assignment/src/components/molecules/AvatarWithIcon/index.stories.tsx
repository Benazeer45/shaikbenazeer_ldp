import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import AvatarWithIcon from '../AvatarWithIcon'; // Ensure the correct import path

// Define the Storybook metadata
const meta: Meta<typeof AvatarWithIcon> = {
    title: 'Molecules/AvatarWithIcon',
    component: AvatarWithIcon,
    argTypes: {
        avatarSrc: { control: 'text' },
        avatarAlt: { control: 'text' },
        avatarWidth: { control: 'text' },
        avatarHeight: { control: 'text' },
        iconSrc: { control: 'text' },
        iconAlt: { control: 'text' },
        iconWidth: { control: 'text' },
        iconHeight: { control: 'text' },
    },
};

export default meta;

// Define the default story
const Template: StoryFn<typeof AvatarWithIcon> = (args) => <AvatarWithIcon {...args} />;


export const CustomAvatarWithIcon = Template.bind({});
CustomAvatarWithIcon.args = {
    avatarSrc: `${process.env.PUBLIC_URL}/assets/icons/avatar.svg`, // Custom avatar path
    avatarAlt: 'Custom Avatar',
    avatarWidth: '40px',
    avatarHeight: '40px',
    iconSrc: `${process.env.PUBLIC_URL}/assets/icons/arrow-bottom.svg`, // Custom icon path
    iconAlt: 'Custom Icon',
    iconWidth: '24px',
    iconHeight: '24px',
};
