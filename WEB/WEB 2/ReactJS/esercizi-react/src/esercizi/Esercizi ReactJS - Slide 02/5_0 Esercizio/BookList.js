import React from "react";

function BookList({ libri }) {
  return (
    <ul className="list-group" id="lista-libri">

      {libri.map((libro, index) => (

        <li key={index} className="list-group-item">
          
          {libro.titolo}
        </li>
      ))}
    </ul>
  );
}

export default BookList;
