## Solution: Viewport-Relative Floating Action Banner Integration

### 1. Frontend: Structural Layout Unification via Sticky Footer Panel

A modern, sticky action bar component (`position: fixed`) was engineered to actively monitor the `dirty` status of the teacher management workspace. This layout pattern entirely bypasses the fragmented legacy approach where operators were trapped in a continuous vertical scrolling loop (scrolling to the top header for "Cancel" or to the bottom grid floor for "Save changes").

* **Unified Save Changes Action:** Aggregates modified row arrays, triggers bulk persistence update endpoints, and updates the view context smoothly.
* **Unified Cancel Action:** Instantly flushes temporary UI modification buffers, restores the active form configuration back to its baseline snapshot, and prevents any viewport jumps or layout repositioning.

---

### 2. State Lifecycle Logic: Reactive Grid Tracking

The component view hooks straight into an active reactive change detection stream (`valueChanges`). Rather than auto-committing input field data or hiding operation controls across static layout extremes, mutations trigger a structural state transformation that animates the overlay banner smoothly into the user's active viewport view.

---

```typescript
// Architectural implementation concept for dynamic banner visibility tracking
this.searchForm.valueChanges
  .pipe(takeUntil(this.destroy$))
  .subscribe((currentState) => {
    const isDirty = JSON.stringify(currentState) !== JSON.stringify(this.initialFormStateSnapshot);
    this.registryService.setGlobalModificationState(isDirty);
  });

```

---

* **Baseline State Tracking:** Stores a deep snapshot copy of the initial matrix configuration data upon component initialization.

* **Viewport Preservation:** Ensures primary administrative validation boundaries remain fully visible to the operator at all times, regardless of the active vertical scroll position across long data rows.

---



## Validation Tests

The updated layout architecture was thoroughly validated across various browser viewport dimensions and deep tabular record lists.

### Test Results

| User UI Interaction Mode | Current Page Position | Global Banner State | Expected Screen Feedback | Actual Rendered Result | Status |
| --- | --- | --- | --- | --- | --- |
| **No Active Modifications** | Top Header Viewport | ❌ HIDDEN | Clean listing workspace view | Standard layout workspace shown | ✅ PASSED |
| **Field Altered (Row 5)** | Mid-Page Scroll Zone | VISIBLE | Banner reveals itself at viewport base | Sticky footer container animated in | ✅ PASSED |
| **Click "Annulla" On Banner** | Mid-Page Scroll Zone | ❌ HIDDEN | Clear dirty inputs; revert to baseline | Form flushed instantly; banner closed | ✅ PASSED |
| **Click "Salva" On Banner** | Deep Bottom List Floor | ❌ HIDDEN | Dispatch payload data; lock new snapshot | Bulk update executed; banner dismissed | ✅ PASSED |

### Visual Feedback on FE



The Floating Action Banner displays dynamically when modifications are present, ensuring action elements track the user's focus seamlessly without forcing continuous wheel navigation:


![Floating Banner](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/FloatingBanner.png?raw=true)


---

The system isolates actions inside a modern viewport-relative overlay layout, keeping primary operational triggers within reachable boundaries:

![Floating Banner Page](https://github.com/jayasuriyanicol/Application-Cloud-Developer/blob/main/Stage%20-%20NTT%20Data/assets/images/FloatingBannerPage.png?raw=true)

---

## Technologies

* **Angular 17+** (Reactive Forms Architecture, View State Observers & Standalone Components)
* **RxJS Reactive Extensions** (Stream Piping, Behavioral Subjects & Lifecycle Unsubscribe Hooks)
* **Tailwind CSS / Bootstrap Grid Systems** (Viewport-Fixed Layout Rules & Layer Z-Indexing Z-100)
* **HTML5 Canvas / DOM Viewport Modules** (Scroll Metric Management & Adaptive Interface Scaling)

---

## Outcome

The refactoring completely eliminates interface friction by introducing a unified and robust state lifecycle layout via the **Global Action Banner Container**. It guarantees full layout usability across large data records, eliminating the historical vertical scrolling penalty while establishing absolute control over active browser data confirmation loops.