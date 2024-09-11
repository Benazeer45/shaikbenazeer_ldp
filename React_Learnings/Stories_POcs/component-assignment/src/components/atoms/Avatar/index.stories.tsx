import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import Avatar from '../Avatar';

export default {
  title: 'Atoms/Avatar',
  component: Avatar,
} as Meta<typeof Avatar>;

const Template: StoryFn<typeof Avatar> = (args) => <Avatar {...args} />;

export const CustomAvatar = Template.bind({});
CustomAvatar.args = {
  src: '/assets/icons/avatar.svg',  // Path relative to the static directory
  alt: 'Custom Size Avatar',
  width: '64px',
  height: '64px',
};
