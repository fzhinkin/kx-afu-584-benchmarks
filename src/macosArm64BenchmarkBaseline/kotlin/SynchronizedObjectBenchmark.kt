package org.example

import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.withLock
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Blackhole
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State

@State(Scope.Benchmark)
open class SynchronizedObjectBaselineBenchmark {
    val so = SynchronizedObject()

    @Benchmark
    fun benchmark(bh: Blackhole) {
        so.withLock {
            bh.consume(42)
        }
    }
}
