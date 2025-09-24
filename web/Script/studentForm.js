function toggleExperienceFields() {
    const experience = document.getElementById('experience').value;
    const yearStarted = document.getElementById('yearStarted');
    const achievements = document.getElementById('achievements');
    
    if (experience === 'Yes') {
        yearStarted.closest('label').style.display = 'block';
        achievements.closest('label').style.display = 'block';
        yearStarted.required = true;
    } else {
        yearStarted.closest('label').style.display = 'none';
        achievements.closest('label').style.display = 'none';
        yearStarted.required = false;
        yearStarted.value = '';
        achievements.value = '';
    }
}

// Initialize on page load
document.addEventListener('DOMContentLoaded', function() {
    toggleExperienceFields();
    
    // Add input validation
    document.getElementById('whatsapp').addEventListener('input', function(e) {
        this.value = this.value.replace(/[^\d+]/g, '');
    });
    
    document.getElementById('studentId').addEventListener('input', function(e) {
        this.value = this.value.toUpperCase();
    });
});