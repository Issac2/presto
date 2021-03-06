/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.execution;

import com.facebook.presto.Session;
import com.facebook.presto.metadata.SessionPropertyManager;
import com.facebook.presto.security.AccessControl;
import com.facebook.presto.server.SessionSupplier;
import com.facebook.presto.spi.QueryId;
import com.facebook.presto.spi.security.Identity;
import com.facebook.presto.transaction.TransactionManager;

import static java.util.Objects.requireNonNull;

public class TestingSessionFactory
        implements SessionSupplier
{
    private final Session session;

    public TestingSessionFactory(Session session)
    {
        this.session = requireNonNull(session, "session is null");
    }

    @Override
    public Identity getIdentity()
    {
        return session.getIdentity();
    }

    @Override
    public Session createSession(QueryId queryId, TransactionManager transactionManager, AccessControl accessControl, SessionPropertyManager sessionPropertyManager)
    {
        return session;
    }
}
