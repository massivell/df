/*
 * MIT License
 *
 * Copyright (c) Copyright (c) 2017-2017, Greatmancode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.greatmancode.legendarybot;

import com.greatmancode.legendarybot.api.utils.StacktraceHandler;
import net.dv8tion.jda.core.utils.SimpleLog;

public class LogListener implements SimpleLog.LogListener {

    private final StacktraceHandler stacktraceHandler;

    public LogListener(IStacktraceHandler stacktraceHandler) {
        this.stacktraceHandler = stacktraceHandler;
    }

    @Override
    public void onLog(SimpleLog log, SimpleLog.Level logLevel, Object message) {
        //Do nothing
    }

    @Override
    public void onError(SimpleLog log, Throwable err) {
        stacktraceHandler.sendStacktrace(err);
    }
}
