import React, { useState, useEffect } from 'react';

function Clock() {
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const timerID = setInterval(() => tick(), 1000);

    return () => {
      clearInterval(timerID);
    };
  }, []);

  function tick() {
    setTime(new Date());
  }

  return (
    <div>
      <h2>Orologio in tempo reale</h2>
      <p>Ora: {time.toLocaleTimeString()}</p>
      <p>Data: {time.toLocaleDateString()}</p>
    </div>
  );
}

export default Clock;
