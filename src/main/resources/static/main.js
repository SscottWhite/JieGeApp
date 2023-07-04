const { PageHeader } = antd;

const MyApp = () => {

    return (
        <div>
            <PageHeader
                style={{
                    border: '1px solid rgb(235, 237, 240)',
                }}
                onBack={() => null}
                title="Title"
                subTitle="This is a subtitle"
            />
        </div>
    )
}


const container = document.getElementById("root");
ReactDOM.render(<MyApp />,container);