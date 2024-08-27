// Function to initialize a counter in localStorage
function initializeLocalStorageCounter() {
    let localCounterValue = localStorage.getItem('localCounter');
    if (!localCounterValue) {
        document.getElementById('localCounter').innerText = "Empty";
        setTimeout(() => {
            localStorage.setItem('localCounter', '0');
            document.getElementById('localCounter').innerText = '0';
        }, 5000);
    } else {
        document.getElementById('localCounter').innerText = localCounterValue;
    }
}

// Function to initialize a counter in sessionStorage
function initializeSessionStorageCounter() {
    let sessionCounterValue = sessionStorage.getItem('sessionCounter');
    if (!sessionCounterValue) {
        document.getElementById('sessionCounter').innerText = "Empty";
        setTimeout(() => {
            sessionStorage.setItem('sessionCounter', '0');
            document.getElementById('sessionCounter').innerText = '0';
        }, 5000);
    } else {
        document.getElementById('sessionCounter').innerText = sessionCounterValue;
    }
}

// Function to increase the localStorage counter
function increaseLocalCounter() {
    let localCount = parseInt(localStorage.getItem('localCounter'), 10) || 0;
    localCount++;
    localStorage.setItem('localCounter', localCount);
    document.getElementById('localCounter').innerText = localCount;
}

// Function to increase the sessionStorage counter
function increaseSessionCounter() {
    let sessionCount = parseInt(sessionStorage.getItem('sessionCounter'), 10) || 0;
    sessionCount++;
    sessionStorage.setItem('sessionCounter', sessionCount);
    document.getElementById('sessionCounter').innerText = sessionCount;
}

// Initialize counters when the page loads
window.onload = () => {
    initializeLocalStorageCounter();
    initializeSessionStorageCounter();

    // Event listener for increasing localStorage counter
    document.getElementById('increaseLocal').addEventListener('click', increaseLocalCounter);

    // Event listener for increasing sessionStorage counter
    document.getElementById('increaseSession').addEventListener('click', increaseSessionCounter);
};
// Function to initialize a counter in localStorage
function initializeLocalStorageCounter() {
    let localCounterValue = localStorage.getItem('localCounter');
    if (!localCounterValue) {
        document.getElementById('localCounter').innerText = "Empty";
        setTimeout(() => {
            localStorage.setItem('localCounter', '0');
            document.getElementById('localCounter').innerText = '0';
        }, 5000);
    } else {
        document.getElementById('localCounter').innerText = localCounterValue;
    }
}

// Function to initialize a counter in sessionStorage
function initializeSessionStorageCounter() {
    let sessionCounterValue = sessionStorage.getItem('sessionCounter');
    if (!sessionCounterValue) {
        document.getElementById('sessionCounter').innerText = "Empty";
        setTimeout(() => {
            sessionStorage.setItem('sessionCounter', '0');
            document.getElementById('sessionCounter').innerText = '0';
        }, 5000);
    } else {
        document.getElementById('sessionCounter').innerText = sessionCounterValue;
    }
}

// Function to increase the localStorage counter
function increaseLocalCounter() {
    let localCount = parseInt(localStorage.getItem('localCounter'), 10) || 0;
    localCount++;
    localStorage.setItem('localCounter', localCount);
    document.getElementById('localCounter').innerText = localCount;
}

// Function to increase the sessionStorage counter
function increaseSessionCounter() {
    let sessionCount = parseInt(sessionStorage.getItem('sessionCounter'), 10) || 0;
    sessionCount++;
    sessionStorage.setItem('sessionCounter', sessionCount);
    document.getElementById('sessionCounter').innerText = sessionCount;
}

// Initialize counters when the page loads
window.onload = () => {
    initializeLocalStorageCounter();
    initializeSessionStorageCounter();

    // Event listener for increasing localStorage counter
    document.getElementById('increaseLocal').addEventListener('click', increaseLocalCounter);

    // Event listener for increasing sessionStorage counter
    document.getElementById('increaseSession').addEventListener('click', increaseSessionCounter);
};
