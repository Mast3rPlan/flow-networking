/*
 * This file is part of Flow Networking, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.networking.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 * {@code ChannelProcessor} can be used in a {@link PreprocessReplayingDecoder} or {@link ProcessingEncoder} to define
 * how a {@code ByteBuf} should be process prior to decode or encode.
 */
public interface ChannelProcessor {
    /**
     * Adds the data contained in the given channel buffer to the processor and returns the output channel buffer. The method may be called from multiple threads.
     * {@code input.release} should NOT be called; it is done externally.
     * {@code buffer.release} should NOT be called; it is done externally.
     *
     * @param ctx the channel handler context
     * @param input the buffer containing the input data
     * @param buffer the buffer to add the data to; will be dynamically-sized
     * @return  
     */
    public ByteBuf process(ChannelHandlerContext ctx, ByteBuf input, ByteBuf buffer);
}