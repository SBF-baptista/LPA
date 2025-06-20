import React, { useEffect, useState } from 'react';

function App() {
  const [devices, setDevices] = useState([]);

  useEffect(() => {
    fetch('/api/devices')
      .then((res) => res.json())
      .then(setDevices)
      .catch(() => setDevices([]));
  }, []);

  return (
    <div>
      <h1>Assobio Test App</h1>
      <ul>
        {devices.map((d) => (
          <li key={d.id}>{d.serialNumber}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
