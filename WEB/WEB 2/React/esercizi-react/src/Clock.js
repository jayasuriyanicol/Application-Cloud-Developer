import React, { useState, useEffect } from 'react';

function Clock({ timezone, country }) {
  const [oraLocale, setOraLocale] = useState(getTime());

  function getTime() {
    const now = new Date();
    // Calcolo ora locale secondo il timezone passato
    const utc = now.getTime() + now.getTimezoneOffset() * 60000;
    const localTime = new Date(utc + 3600000 * timezone);
    return localTime.toLocaleTimeString();
  }

  useEffect(() => {
    const timer = setInterval(() => {
      setOraLocale(getTime());
    }, 1000);

    return () => clearInterval(timer); // Pulizia del timer
  }, []);

  return (
    <div className="mt-3">
      <h4>Orario in {country}:</h4>
      <p>{oraLocale}</p>
    </div>
  );
}

export default Clock;
