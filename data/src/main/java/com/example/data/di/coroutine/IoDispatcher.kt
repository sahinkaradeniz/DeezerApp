package com.example.data.di.coroutine

import javax.inject.Qualifier

/**
 * IoDispatcher is a qualifier annotation for the I/O dispatcher.
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher