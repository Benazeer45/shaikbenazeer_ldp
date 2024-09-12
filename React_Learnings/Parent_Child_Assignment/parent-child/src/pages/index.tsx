import React from 'react';
import { SummaryTemplate } from '../components/templates/MainTemplate';
import { SummarySection } from '../components/organisms/SummarySection'; // Import the organism

export const SummaryPage: React.FC = () => {
  return (
    <SummaryTemplate> {/* Use the template to wrap the page content */}
      <SummarySection /> {/* Add the SummarySection organism inside the template */}
    </SummaryTemplate>
  );
};

export default SummaryPage;
