import React, { Component } from 'react';

interface State {
  count: number;
}
class CounterClass extends Component<{}, State> {
  constructor(props: {}) {
    super(props);
    this.state = {
      count: 0,
    };
  }

  componentDidMount() {
    console.log('Class Component did mount occured');
  }

  componentDidUpdate(prevProps: {}, prevState: State) {
    if (this.state.count !== prevState.count) {
      console.log('Class Component did update');
    }
  }

  componentWillUnmount() {
    console.log('Class Component will unmount');
  }

  increment = () => {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  };

  render() {
    return (
      <div>
        <h3>Count: {this.state.count}</h3>
        <button onClick={this.increment}>Increment</button>
      </div>
    );
  }
}

export default CounterClass;
