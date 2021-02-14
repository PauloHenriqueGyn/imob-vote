package br.com.imobvote.arquitetura.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.PostgresUUIDType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class PostgreA2ODialect extends PostgreSQL9Dialect {

	public PostgreA2ODialect() {
		super();
		registerColumnType(Types.BLOB, "bytea");
		registerFunction( "char_length", new StandardSQLFunction("char_length",StandardBasicTypes.LONG));
	}

	@Override
	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
		if (sqlTypeDescriptor.getSqlType() == java.sql.Types.BLOB) {
			return BinaryTypeDescriptor.INSTANCE;
		}
		return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
	}

	@Override
	public void contributeTypes(final TypeContributions typeContributions, final ServiceRegistry serviceRegistry) {
		super.contributeTypes(typeContributions, serviceRegistry);
		typeContributions.contributeType(new JHipsterPostgresUUIDType());
	}

	@SuppressWarnings("serial")
	protected static class JHipsterPostgresUUIDType extends PostgresUUIDType {

		@Override
		public String getName() {
			return "uuid-jhipster";
		}

		@Override
		protected boolean registerUnderJavaType() {
			return true;
		}
	}
}
