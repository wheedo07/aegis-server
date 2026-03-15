const path = require('path');

module.exports = {
    entry: {
        index: path.resolve(__dirname, './src/main/resources/ts/index.ts'),
        style: path.resolve(__dirname, './src/main/resources/ts/style.ts'),
    },
    module: {
        rules: [
            {
                test: /\.ts$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
            {
                test: /\.css$/i,
                use: ['style-loader', 'css-loader'],
            },
        ],
    },
    resolve: {
        extensions: ['.ts', '.js'],
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, './src/main/resources/static/js'),
        clean: true
    },
    mode: 'development',
    devtool: 'inline-source-map',
    
    optimization: {
        splitChunks: {
            cacheGroups: {
                vendor: {
                    test: /[\\/]node_modules[\\/]/,
                    name: 'vendor',
                    chunks: (chunk) => {
                        return chunk.name != 'style';
                    },
                    enforce: true
                },
            },
        },
    },
};