Postgres server  command

1.brew install postgresql
2.pg_ctl -D /usr/local/var/postgres start && brew services start postgresql
3.postgres -V

postgres-# \du
                                    List of roles
  Role name  |                         Attributes                         | Member of 
-------------+------------------------------------------------------------+-----------
 ajay.maurya | Superuser, Create role, Create DB, Replication, Bypass RLS | {}


Very important for mapping with hibernate.cfg.xml file
