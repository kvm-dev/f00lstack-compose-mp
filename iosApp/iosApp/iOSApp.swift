import SwiftUI

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    func registerBackgroundTasks() {
        BGTaskScheduler.shared.registerForTaskWithIdentifier(identifier: "ru.kvmsoft.foolstack.loggerOfflineAuthTask", using: nil) { task in
            // Run the work here
            // You can call your shared Kotlin function here:
            // performBackgroundSync()
        }
    }
}