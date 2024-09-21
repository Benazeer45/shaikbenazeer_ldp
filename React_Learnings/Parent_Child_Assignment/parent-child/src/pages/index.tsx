import React from 'react';
import { SummaryTemplate } from '../components/templates/MainTemplate';
import { SummaryCard } from '../components/organisms/SummaryCard'; // Import the organism

export const SummaryPage: React.FC = () => {
  return (
    <SummaryTemplate> {/* Use the template to wrap the page content */}
      <SummaryCard /> {/* Add the SummarySection organism inside the template */}
    </SummaryTemplate>
  );
};

export default SummaryPage;
