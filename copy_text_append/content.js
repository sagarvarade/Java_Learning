document.addEventListener('copy', () => {
  navigator.clipboard.readText().then(text => {
    chrome.runtime.sendMessage({ action: 'appendText', text: text });
  }).catch(err => {
    console.error('Failed to read clipboard contents: ', err);
  });
});
