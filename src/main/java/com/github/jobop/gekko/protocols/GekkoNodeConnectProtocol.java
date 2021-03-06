/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by CuttleFish on 2020/7/2.
 */
package com.github.jobop.gekko.protocols;


import com.alipay.remoting.InvokeCallback;
import com.github.jobop.gekko.core.GekkoNode;
import com.github.jobop.gekko.core.election.PreVoteCollector;
import com.github.jobop.gekko.core.election.VoteCollector;
import com.github.jobop.gekko.core.metadata.Peer;
import com.github.jobop.gekko.core.replication.AcceptCollector;
import com.github.jobop.gekko.core.replication.PenddingEntryBatch;
import com.github.jobop.gekko.protocols.message.GekkoEntry;

import java.util.List;

public interface GekkoNodeConnectProtocol {
    public void sendHeartBeat();

    public void sendProbe(Peer peer, InvokeCallback callback);

    public void reqVote(VoteCollector voteCollector);

    public void preVote(PreVoteCollector preVoteCollector);

    public void pushDatas(List<GekkoEntry> entrys, AcceptCollector callback);
    public void pushDatas(Peer peer, PenddingEntryBatch penddingEntry, InvokeCallback callback);

    public List<GekkoEntry> pullEntriesByFollower(long fromIndex, long toIndex);
}
