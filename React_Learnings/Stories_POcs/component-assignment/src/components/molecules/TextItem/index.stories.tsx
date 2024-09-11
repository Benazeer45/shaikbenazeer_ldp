import { Meta, StoryFn } from '@storybook/react';
import TextItem from '../TextItem'; // Adjust the import path as needed

const meta: Meta<typeof TextItem> = {
    title: 'Molecules/TextItem',
    component: TextItem,
    argTypes: {
        imageSrc: { control: 'text' },
        text: { control: 'text' },
        isSeeder: { control: 'boolean' },
        color: { control: 'color' }, // Add color control
    },
};

export default meta;

const Template: StoryFn<typeof TextItem> = (args) => <TextItem {...args} />;

export const CustomTextItem = Template.bind({});
CustomTextItem.args = {
    imageSrc: '/assets/icons/icon1.svg', // Path to image in public directory
    text: 'Seeder',
    isSeeder: true,
    color: '#000000', // Default color
};
