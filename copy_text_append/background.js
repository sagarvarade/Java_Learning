let copiedTexts = [];

// Listen for messages from content script
chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
  if (message.action === 'appendText') {
    copiedTexts.push(message.text);
    chrome.storage.local.set({ copiedTexts });
  }
});

// Function to generate and download the file
function downloadTextFile() {
  chrome.storage.local.get(['copiedTexts'], function(result) {
    const texts = result.copiedTexts || [];
    const blob = new Blob(texts, { type: 'text/plain' });
    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = 'copied_texts.txt';
    link.click();

    // Cleanup
    URL.revokeObjectURL(url);
  });
}

// Message listener for the download button in popup
chrome.runtime.onMessage.addListener((message, sender, sendResponse) => {
  if (message.action === 'downloadFile') {
    downloadTextFile();
  }
});
