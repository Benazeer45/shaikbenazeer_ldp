
        // Initialize scores on page load
        function initializeScores() {
            // Get local score from localStorage or default to 0
            const localScore = localStorage.getItem('localScore') || 0;
            document.getElementById('local-score').textContent = localScore;

            // Get session score from sessionStorage or default to 0
            const sessionScore = sessionStorage.getItem('sessionScore') || 0;
            document.getElementById('session-score').textContent = sessionScore;
        }

        // Increment scores
        function incrementScores() {
            // Get current scores
            let localScore = parseInt(localStorage.getItem('localScore') || '0');
            let sessionScore = parseInt(sessionStorage.getItem('sessionScore') || '0');

            // Increment scores
            localScore++;
            sessionScore++;

            // Update localStorage and sessionStorage
            localStorage.setItem('localScore', localScore);
            sessionStorage.setItem('sessionScore', sessionScore);

            // Update displayed scores
            document.getElementById('local-score').textContent = localScore;
            document.getElementById('session-score').textContent = sessionScore;
        }

        // Decrement scores
        function decrementScores() {
            // Get current scores
            let localScore = parseInt(localStorage.getItem('localScore') || '0');
            let sessionScore = parseInt(sessionStorage.getItem('sessionScore') || '0');

            // Decrement scores
            localScore--;
            sessionScore--;

            // Ensure scores don't go below 0
            localScore = Math.max(localScore, 0);
            sessionScore = Math.max(sessionScore, 0);

            // Update localStorage and sessionStorage
            localStorage.setItem('localScore', localScore);
            sessionStorage.setItem('sessionScore', sessionScore);

            // Update displayed scores
            document.getElementById('local-score').textContent = localScore;
            document.getElementById('session-score').textContent = sessionScore;
        }

        // Clear scores
        function clearScores() {
            // Clear localStorage and sessionStorage
            localStorage.removeItem('localScore');
            sessionStorage.removeItem('sessionScore');

            // Reset displayed scores
            document.getElementById('local-score').textContent = '0';
            document.getElementById('session-score').textContent = '0';
        }

        // Initialize scores when the page loads
        window.onload = initializeScores;