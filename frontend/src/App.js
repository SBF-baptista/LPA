import React, { useEffect, useState } from 'react';

function App() {
  const [devices, setDevices] = useState([]);
  const [command, setCommand] = useState('');

  useEffect(() => {
    fetch('/api/devices')
      .then((res) => res.json())
      .then(setDevices)
      .catch(() => setDevices([]));
  }, []);

  const runFirmware = (serial) => {
    fetch(`/api/firmware/run?serialNumber=${serial}&firmwareCommand=${command}`, {
      method: 'POST'
    });
  };

  const uploadImage = async (e, deviceId) => {
    const file = e.target.files[0];
    if (!file) return;
    const form = new FormData();
    form.append('deviceId', deviceId);
    form.append('step', 'assembly');
    form.append('file', file);
    await fetch('/api/images/upload', {
      method: 'POST',
      body: form
    });
  };

  return (
    <div>
      <h1>Assobio Test App</h1>
      <input
        value={command}
        onChange={(e) => setCommand(e.target.value)}
        placeholder="Firmware command"
      />
      <ul>
        {devices.map((d) => (
          <li key={d.id}>
            {d.serialNumber}
            <button onClick={() => runFirmware(d.serialNumber)}>Run</button>
            <input type="file" onChange={(e) => uploadImage(e, d.id)} />
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
