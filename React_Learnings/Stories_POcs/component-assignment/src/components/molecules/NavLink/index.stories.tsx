import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import NavLink, { NavLinkProps } from '../NavLink'; // Adjust the import path as needed

export default {
  title: 'Molecules/NavLink',
  component: NavLink,
  argTypes: {
    text: {
      control: 'text',
      description: 'Text displayed in the navigation link',
      defaultValue: 'Home',
    },
    icon: {
      control: 'select', // Use 'select' to choose between different icons
      options: ['Home'], // Add any icons you need
      mapping: {
        Home: <img src={`${process.env.PUBLIC_URL}/assets/icons/coin.svg`} alt="Home Icon" />,
      },
    },
    style: {
      control: 'object',
      description: 'Custom styles for the NavLink',
    },
  },
} as Meta;

const Template: StoryFn<NavLinkProps> = (args) => <NavLink {...args} />;


export const ActiveLink = Template.bind({});
ActiveLink.args = {
  text: 'Cash acceleration',
  active: true,
  style: {},
};
