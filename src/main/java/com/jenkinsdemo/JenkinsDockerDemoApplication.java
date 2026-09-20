package com.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDockerDemoApplication.class, args);
    }

    @GetMapping(value = "/", produces = "text/html")
    public String dashboard() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>CloudOps Dashboard</title>

                <meta name="viewport"
                      content="width=device-width, initial-scale=1">

                <style>

                    * {
                        box-sizing: border-box;
                        margin: 0;
                        padding: 0;
                        font-family: Arial, sans-serif;
                    }

                    body {
                        background: #f4f7fb;
                        color: #1f2937;
                    }

                    .header {
                        height: 70px;
                        background: #111827;
                        color: white;
                        display: flex;
                        align-items: center;
                        justify-content: space-between;
                        padding: 0 30px;
                    }

                    .logo {
                        font-size: 24px;
                        font-weight: bold;
                    }

                    .system-status {
                        color: #22c55e;
                        font-size: 14px;
                    }

                    .layout {
                        display: flex;
                        min-height: calc(100vh - 70px);
                    }

                    .sidebar {
                        width: 230px;
                        background: #1f2937;
                        padding: 20px 12px;
                    }

                    .menu-item {
                        color: #d1d5db;
                        padding: 14px;
                        margin-bottom: 6px;
                        border-radius: 8px;
                        cursor: pointer;
                        transition: 0.2s;
                    }

                    .menu-item:hover {
                        background: #374151;
                        color: white;
                    }

                    .menu-item.active {
                        background: #2563eb;
                        color: white;
                    }

                    .content {
                        flex: 1;
                        padding: 35px;
                    }

                    .page {
                        display: none;
                    }

                    .page.active {
                        display: block;
                    }

                    h1 {
                        font-size: 28px;
                        margin-bottom: 8px;
                    }

                    .subtitle {
                        color: #6b7280;
                        margin-bottom: 30px;
                    }

                    .cards {
                        display: grid;
                        grid-template-columns:
                            repeat(4, 1fr);
                        gap: 20px;
                        margin-bottom: 25px;
                    }

                    .card {
                        background: white;
                        padding: 22px;
                        border-radius: 12px;
                        box-shadow:
                            0 2px 8px rgba(0,0,0,0.08);
                    }

                    .card-title {
                        color: #6b7280;
                        font-size: 13px;
                        margin-bottom: 10px;
                    }

                    .number {
                        font-size: 30px;
                        font-weight: bold;
                    }

                    .green {
                        color: #16a34a;
                    }

                    .orange {
                        color: #d97706;
                    }

                    .red {
                        color: #dc2626;
                    }

                    .section {
                        background: white;
                        padding: 25px;
                        border-radius: 12px;
                        margin-bottom: 25px;
                        box-shadow:
                            0 2px 8px rgba(0,0,0,0.08);
                    }

                    .section h2 {
                        margin-bottom: 20px;
                    }

                    .server {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        padding: 17px 0;
                        border-bottom:
                            1px solid #e5e7eb;
                    }

                    .server:last-child {
                        border-bottom: none;
                    }

                    .badge {
                        padding: 6px 12px;
                        border-radius: 20px;
                        font-size: 12px;
                        background: #dcfce7;
                        color: #166534;
                    }

                    .warning-badge {
                        background: #fef3c7;
                        color: #92400e;
                    }

                    .offline-badge {
                        background: #fee2e2;
                        color: #991b1b;
                    }

                    .progress-container {
                        margin-top: 15px;
                    }

                    .progress-label {
                        display: flex;
                        justify-content: space-between;
                        margin-bottom: 7px;
                        font-size: 14px;
                    }

                    .progress {
                        height: 10px;
                        background: #e5e7eb;
                        border-radius: 10px;
                        overflow: hidden;
                    }

                    .progress-bar {
                        height: 100%;
                        border-radius: 10px;
                    }

                    .cpu {
                        width: 72%;
                        background: #2563eb;
                    }

                    .memory {
                        width: 51%;
                        background: #16a34a;
                    }

                    .storage {
                        width: 84%;
                        background: #d97706;
                    }

                    .deployment {
                        display: flex;
                        justify-content: space-between;
                        padding: 16px 0;
                        border-bottom:
                            1px solid #e5e7eb;
                    }

                    .deployment:last-child {
                        border-bottom: none;
                    }

                    .success {
                        color: #16a34a;
                        font-weight: bold;
                    }

                    .log {
                        padding: 13px;
                        margin-bottom: 8px;
                        background: #111827;
                        color: #d1d5db;
                        border-radius: 6px;
                        font-family: monospace;
                        font-size: 13px;
                    }

                    .refresh-btn {
                        margin-top: 20px;
                        padding: 10px 18px;
                        background: #2563eb;
                        color: white;
                        border: none;
                        border-radius: 7px;
                        cursor: pointer;
                    }

                    .refresh-btn:hover {
                        background: #1d4ed8;
                    }

                    @media (max-width: 900px) {

                        .cards {
                            grid-template-columns:
                                repeat(2, 1fr);
                        }

                        .sidebar {
                            width: 190px;
                        }
                    }

                    @media (max-width: 650px) {

                        .sidebar {
                            display: none;
                        }

                        .content {
                            padding: 20px;
                        }

                        .cards {
                            grid-template-columns: 1fr;
                        }
                    }

                </style>
            </head>

            <body>

                <div class="header">

                    <div class="logo">
                        ☁ CloudOps
                    </div>

                    <div class="system-status">
                        ● System Operational
                    </div>

                </div>

                <div class="layout">

                    <div class="sidebar">

                        <div class="menu-item active"
                             onclick="showPage('dashboard', this)">
                            📊 Dashboard
                        </div>

                        <div class="menu-item"
                             onclick="showPage('servers', this)">
                            🖥 Servers
                        </div>

                        <div class="menu-item"
                             onclick="showPage('deployments', this)">
                            🚀 Deployments
                        </div>

                        <div class="menu-item"
                             onclick="showPage('monitoring', this)">
                            📈 Monitoring
                        </div>

                        <div class="menu-item"
                             onclick="showPage('logs', this)">
                            📋 Logs
                        </div>

                    </div>

                    <div class="content">

                        <!-- DASHBOARD -->

                        <div id="dashboard"
                             class="page active">

                            <h1>
                                Infrastructure Dashboard
                            </h1>

                            <p class="subtitle">
                                Monitor your cloud infrastructure
                                and application deployments.
                            </p>

                            <div class="cards">

                                <div class="card">
                                    <div class="card-title">
                                        SERVERS ONLINE
                                    </div>

                                    <div class="number green">
                                        12
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-title">
                                        WARNINGS
                                    </div>

                                    <div class="number orange">
                                        2
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-title">
                                        OFFLINE
                                    </div>

                                    <div class="number red">
                                        1
                                    </div>
                                </div>

                                <div class="card">
                                    <div class="card-title">
                                        DEPLOYMENTS
                                    </div>

                                    <div class="number">
                                        48
                                    </div>
                                </div>

                            </div>

                            <div class="section">

                                <h2>
                                    🖥 Infrastructure Summary
                                </h2>

                                <div class="server">
                                    <span>
                                        Production Environment
                                    </span>

                                    <span class="badge">
                                        Healthy
                                    </span>
                                </div>

                                <div class="server">
                                    <span>
                                        Database Environment
                                    </span>

                                    <span class="badge warning-badge">
                                        Warning
                                    </span>
                                </div>

                                <div class="server">
                                    <span>
                                        Backup Environment
                                    </span>

                                    <span class="badge">
                                        Healthy
                                    </span>
                                </div>

                            </div>

                        </div>


                        <!-- SERVERS -->

                        <div id="servers"
                             class="page">

                            <h1>
                                Server Infrastructure
                            </h1>

                            <p class="subtitle">
                                Monitor server availability.
                            </p>

                            <div class="section">

                                <div class="server">
                                    <span>
                                        🖥 Production-Web-01
                                    </span>

                                    <span class="badge">
                                        ● Online
                                    </span>
                                </div>

                                <div class="server">
                                    <span>
                                        🖥 Production-Web-02
                                    </span>

                                    <span class="badge">
                                        ● Online
                                    </span>
                                </div>

                                <div class="server">
                                    <span>
                                        🗄 Database-01
                                    </span>

                                    <span class="badge warning-badge">
                                        ● Warning
                                    </span>
                                </div>

                                <div class="server">
                                    <span>
                                        💾 Backup-Server
                                    </span>

                                    <span class="badge">
                                        ● Online
                                    </span>
                                </div>

                                <button class="refresh-btn"
                                        onclick="alert('Server status refreshed!')">
                                    ↻ Refresh Status
                                </button>

                            </div>

                        </div>


                        <!-- DEPLOYMENTS -->

                        <div id="deployments"
                             class="page">

                            <h1>
                                Deployment History
                            </h1>

                            <p class="subtitle">
                                Track application deployments.
                            </p>

                            <div class="section">

                                <div class="deployment">

                                    <span>
                                        v1.4.2 — Production
                                    </span>

                                    <span class="success">
                                        ✓ Successful
                                    </span>

                                </div>

                                <div class="deployment">

                                    <span>
                                        v1.4.1 — Production
                                    </span>

                                    <span class="success">
                                        ✓ Successful
                                    </span>

                                </div>

                                <div class="deployment">

                                    <span>
                                        v1.4.0 — Staging
                                    </span>

                                    <span class="success">
                                        ✓ Successful
                                    </span>

                                </div>

                                <div class="deployment">

                                    <span>
                                        v1.3.9 — Production
                                    </span>

                                    <span class="success">
                                        ✓ Successful
                                    </span>

                                </div>

                            </div>

                        </div>


                        <!-- MONITORING -->

                        <div id="monitoring"
                             class="page">

                            <h1>
                                System Monitoring
                            </h1>

                            <p class="subtitle">
                                Current infrastructure utilization.
                            </p>

                            <div class="section">

                                <div class="progress-container">

                                    <div class="progress-label">
                                        <span>CPU Usage</span>
                                        <strong>72%</strong>
                                    </div>

                                    <div class="progress">
                                        <div class="progress-bar cpu">
                                        </div>
                                    </div>

                                </div>


                                <div class="progress-container">

                                    <div class="progress-label">
                                        <span>Memory Usage</span>
                                        <strong>51%</strong>
                                    </div>

                                    <div class="progress">
                                        <div class="progress-bar memory">
                                        </div>
                                    </div>

                                </div>


                                <div class="progress-container">

                                    <div class="progress-label">
                                        <span>Storage Usage</span>
                                        <strong>84%</strong>
                                    </div>

                                    <div class="progress">
                                        <div class="progress-bar storage">
                                        </div>
                                    </div>

                                </div>

                            </div>

                        </div>


                        <!-- LOGS -->

                        <div id="logs"
                             class="page">

                            <h1>
                                Application Logs
                            </h1>

                            <p class="subtitle">
                                Recent system events.
                            </p>

                            <div class="section">

                                <div class="log">
                                    [INFO] Application started successfully
                                </div>

                                <div class="log">
                                    [INFO] Docker container started
                                </div>

                                <div class="log">
                                    [INFO] Jenkins deployment completed
                                </div>

                                <div class="log">
                                    [INFO] Database connection established
                                </div>

                                <div class="log">
                                    [INFO] Health check: OK
                                </div>

                            </div>

                        </div>

                    </div>

                </div>


                <script>

                    function showPage(pageId, element) {

                        const pages =
                            document.querySelectorAll('.page');

                        pages.forEach(function(page) {
                            page.classList.remove('active');
                        });

                        document
                            .getElementById(pageId)
                            .classList.add('active');

                        const menuItems =
                            document.querySelectorAll('.menu-item');

                        menuItems.forEach(function(item) {
                            item.classList.remove('active');
                        });

                        element.classList.add('active');
                    }

                </script>

            </body>
            </html>
            """;
    }
}