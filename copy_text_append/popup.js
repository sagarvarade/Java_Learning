document.getElementById('download-btn').addEventListener('click', () => {
  chrome.runtime.sendMessage({ action: 'downloadFile' });
});
