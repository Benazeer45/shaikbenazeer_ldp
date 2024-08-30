import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import Button from './index';

test('Button click event', () => {
  const handleClick = jest.fn();
  render(<Button onClick={handleClick}>Click Me</Button>);
  fireEvent.click(screen.getByText('Click Me'));
  expect(handleClick).toHaveBeenCalledTimes(1);
});
