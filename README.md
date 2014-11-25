gwt-2.7-rc1-test
================

This is a demo app to test how the GWT Scheduler works different on mobile and on desktop in Super Dev Mode.

I printed the height of a HTMLPanel for three different cases. 

1. right after the DOM elements are inserted into the page (GWTP onReveal())
2. right after the DOM elements are inserted into the page and Scheduler with a deferred command is executed
3. right after the DOM elements are inserted into the page and a Timer after 1000mx is fired

Here is the difference in the console output:

Output on Desktop
=================

- height before Timer and Scheduler: 0
- height after Scheduler: 652
- height after Timer: 652 


Output on Mobile (iPhone 5, iOS 7.1.1)
=====================================

- height before Timer and Scheduler: 0
- height after Scheduler: 425
- height after Timer: 817

