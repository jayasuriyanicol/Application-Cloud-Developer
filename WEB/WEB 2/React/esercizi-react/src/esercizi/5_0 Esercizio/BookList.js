import React from "react";

function BookList({ libri }) {
  return (
    <div className="mt-3">
      <h4>Lista dei Libri</h4>
      <ul className="list-group">
        {libri.map((libro, index) => (
          <li key={index} className="list-group-item">
            {index + 1}) {libro.titolo}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookList;
