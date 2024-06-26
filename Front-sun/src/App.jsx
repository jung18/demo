import { BrowserRouter as Router } from 'react-router-dom';
import './App.css';
import Nav from './assets/components/Nav/Nav';
import Main from './assets/components/Main/Main';

function App() {
  return (
    <Router>
      <div className='container'>
        <Nav />
        {/* <Main /> */}
      </div>
    </Router>
  );
}

export default App;