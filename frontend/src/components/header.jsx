
import './header.css';

function Header() {
    return (
        <header className="site-header">
            <div className="header-container">

                <a href="#inicio" className="logo">
                    <span className="logo-icon">L</span>
                    <span>level<span className = "logo-span">boxd</span>.</span>
                </a>

                <nav className="menu">
                    <a href="#jogos">Jogos</a>
                    <a href="#listas">Listas</a>
                    <a href="#perfil">Meu Perfil</a>
                </nav>

            </div>
        </header>
    );
}

export default Header;
