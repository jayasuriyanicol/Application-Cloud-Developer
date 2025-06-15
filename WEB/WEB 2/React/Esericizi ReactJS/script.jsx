const elementRoot = document.querySelector("#root");
const root = ReactDOM.createRoot(elementRoot);


//APPROCCIO DEI PARAMETRI CON LE COMPONENTI


//Sintassi per crear una const, utilizzaimo sempre per convenzione "props"

//Invece di utilizzare propos.children possiamo chiamarla direttamente children levando il console.log()


const App = ({children}) => {
  
  return (
    <div className="main">
      <h1>Primo componente</h1>
      {children}
    </div>
  );
};
const List = function () {
  return (
    <ul>
      <li>PHP</li>
      <li>JS</li>
      <li>Python</li>
    </ul>
  );
};

root.render(
  <>
    <App>
        <h2>Lista comeptenze</h2>
        <List/> 
    </App>
   
  </>
);


ì