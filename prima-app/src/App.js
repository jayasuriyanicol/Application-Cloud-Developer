import logo from './logo.svg';
import './App.css';
import Componente1 from './Componente1';

function getDate(date){
  return date.toLocaleDateString()+" "+date.toLocaleTimeString()
}
function App() {
  let nome="Nicol"
  return (
    <div className="App">
      <Componente1></Componente1>
      <h1> Prima App React</h1>
      <h2>

       {

          new Date().toLocaleDateString()+" "+ new Date().toLocaleTimeString()
       }


      </h2> 
     {/*Possiamo iterarlo più volte*/}
      <h2>{getDate(new Date())}</h2>
    </div>
  );
}

export default App;

