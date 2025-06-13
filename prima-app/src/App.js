import logo from './logo.svg';
import './App.css';
import Componente1 from './Componente1'
import Clock from './Clock';

function getDate(date){
  return date.toLocaleDateString()+" "+date.toLocaleTimeString()
}
let nome="Nicol"
function App() {
  return (
    <div className="App">
      
      <Componente1 nome="Nicol" cognome="Jayasuriya" eta="21"></Componente1>
      <Componente1 nome="Nathan" cognome="Mbuyamba" eta="21"></Componente1>
      <Componente1 nome="Michael" cognome="Baciarello" eta="21"></Componente1>

      <h1> Prima App React {nome}</h1>
      <h2>

       {
          new Date().toLocaleDateString()+" "+ new Date().toLocaleTimeString()

       }


      </h2> 


     {/*Possiamo iterarlo più volte*/}

     <Clock timezone= "0" country="Italia"></Clock>
     <Clock timezone= "-6" country="USA"></Clock>
     <Clock timezone= "7" country="Japan"></Clock>

    </div>
  );
}

export default App;

