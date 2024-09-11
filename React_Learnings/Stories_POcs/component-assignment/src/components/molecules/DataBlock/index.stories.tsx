import React from 'react';
import { Meta, StoryFn } from '@storybook/react';
import { DataBlock, DataBlockProps } from '../DataBlock';

export default {
  title: 'Molecules/DataBlock',
  component: DataBlock,
  argTypes: {
    icon: {
      control: 'select',
      options: ['Calendar', 'Document', 'Percentage'], // Use string options
    },
    title: { control: 'text' },
    subtitle: { control: 'text' },
    extraIcon: {
      control: 'text',
    },
  },
} as Meta;

const iconMap: { [key: string]: JSX.Element } = {
  Calendar: <img src={`${process.env.PUBLIC_URL}/assets/icons/calendar.svg`} style={{ width: '40px', height: '40px' }} alt="Icon" />,
  Document: <img src={`${process.env.PUBLIC_URL}/assets/icons/document-download.svg`} style={{ width: '40px', height: '40px' }} alt="Icon" />,
  Percentage: <img src={`${process.env.PUBLIC_URL}/assets/icons/percentage-square.svg`} style={{ width: '40px', height: '40px' }} alt="Icon" />,
};

const Template: StoryFn<DataBlockProps> = (args) => {
  const { icon, ...rest } = args;
  return <DataBlock icon={iconMap[icon as string]} {...rest} />;
};

export const CustomDataBlock = Template.bind({});
CustomDataBlock.args = {
  icon: 'Calendar', // Set a default string value
  title: 'Sample Title',
  subtitle: 'Sample Subtitle',
  extraIcon: <img src={`${process.env.PUBLIC_URL}/assets/icons/Frame 1000004272.svg`} style={{ width: '16px', height: '16px' }} alt="Extra Icon" />,
};
