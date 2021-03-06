module.exports = function(sequelize, DataTypes) {
    return sequelize.define('sitioturistico', {
        idSitioTuristico: {
            type: DataTypes.INTEGER(10),
            allowNull: false,
            primaryKey: true,
            autoIncrement: true
        },
		idMunicipio: {
            type: DataTypes.INTEGER,
            allowNull: true,
            references: {
                model: 'municipio',
                key: 'idMunicipio'
            }
        },
        nombre: {
            type: DataTypes.STRING,
            allowNull: true
        },
        descripcion: {
            type: DataTypes.STRING,
            allowNull: true
        }
    }, {
        tableName: 'sitioTuristico',
        timestamps:false
    });
};

